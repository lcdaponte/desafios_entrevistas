import styled from 'styled-components';

export const UserInfo = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  img{
    width: 170px;
    border-radius: 50%;
  }

  h1{
    font-size: 20px;
    margin-top: 10px;
  }

  a{
    font-size: 14px;
    text-decoration: none;
    color: #4A506A;
    margin-bottom: 12px;
  }

`;

export const RepoList = styled.ul`
  margin-top: 40px;
  list-style: none;
  li {
    padding: 20px 0;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-content: center;
  }

  a{
    text-decoration: none;
    color: #4A506A;
  }
`;

export const ErrorMessage = styled.div`
  color: red;
  display: flex;
  flex-direction: row;
  align-content: center;
`;