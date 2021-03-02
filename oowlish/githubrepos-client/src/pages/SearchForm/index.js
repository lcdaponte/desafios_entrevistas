import React, { useState } from "react";
import { FaGithub, FaSearch } from "react-icons/fa";
import Container from "../../components/Container";
import { Form, BtnSubmit } from "./styles";

function SearchForm(props) {
  const [username, setUsername] = useState("");

  function handleUsername(e) {
    setUsername(e.target.value);
  }

  async function handleSubmit(e) {
    e.preventDefault();

    if (!username) {
      alert('Username has to ');
      return;
    }

    props.history.push({
      pathname: "/repos",
      state: { username: username },
    });
  }

  return (
      <Container>
        <h1>
          <FaGithub />
          Github Repositories by username
        </h1>

        <Form onSubmit={handleSubmit} data-testid="search-form">
          <input
            type="text"
            placeholder="username"
            value={username}
            onChange={handleUsername}
            data-testid="username"
          />
          <BtnSubmit>
            <FaSearch />
          </BtnSubmit>
        </Form>
      </Container>
  );
}

export default SearchForm;
