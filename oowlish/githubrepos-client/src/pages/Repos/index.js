import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import ReactPaginate from "react-paginate";
import Container from "../../components/Container";
import { UserInfo, RepoList, ErrorMessage } from "./styles";
import api from "../../services/api";

function Repos(props) {
  const [offset, setOffset] = useState(0);
  const [data, setData] = useState([]);
  const [perPage, setPerPage] = useState(10);
  const [currentPage, setCurrentPage] = useState(0);
  const [pageCount, setPageCount] = useState(0);
  const [username, setUsername] = useState("");
  const [avatar, setAvatar] = useState("");
  const [loading, setLoading] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    searchData();
  }, [currentPage, offset]);

  function handlePageClick(e) {
    const selectedPage = e.selected;
    const offsetSelected = selectedPage * perPage;

    setCurrentPage(selectedPage);
    setOffset(offsetSelected);
  }

  async function searchData() {
    setLoading(true);

    try {
      const response = await api.get(
        `/repos?username=${props.location.state.username}`
      );
      const data = response.data;

      const slicedRepos = data.repositories.slice(offset, offset + perPage);

      const repoData = slicedRepos.map((repo) => (
        <li key={repo.name}>
          <span>{repo.name}</span>
          <a href={repo.url} rel="noopener noreferrer" target="_blank">
            More details...
          </a>
        </li>
      ));

      setPageCount(Math.ceil(data.repositories.length / perPage));
      setUsername(data.username);
      setAvatar(data.avatar);
      setData(repoData);
      setLoading(false);
    } catch (error) {
      console.log(`error: ${error}`);
      setErrorMessage('You have entered an invalid username.');
    }
  }

  return (
    <Container>
      <UserInfo>
        <Link to="/">Go back to search</Link>
        <img src={avatar} alt={username} />
        <h1>{username}</h1>
      </UserInfo>

      <RepoList>{data}</RepoList>
      
      <ErrorMessage className="errormsg">{ errorMessage}</ErrorMessage>

      {!loading ? (
        <ReactPaginate
          forcePage={currentPage}
          pageCount={pageCount}
          marginPagesDisplayed={10}
          pageRangeDisplayed={5}
          onPageChange={handlePageClick}
          nextLabel="&rarr;"
          previousLabel="&larr;"
          containerClassName={"pagination"}
          subContainerClassName={"pages pagination"}
          activeClassName={"active"}
        />
      ) : (
        ""
      )}
    </Container>
  );
}

export default Repos;