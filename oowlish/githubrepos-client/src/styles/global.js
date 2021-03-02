import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    outline: 0;
    box-sizing: border-box;
  }

  html, body, #root {
    min-height: 100%;
  }

  button {
    cursor: pointer;
  }

  body {
    background: #4A506A;
  }

  .pagination {
  margin: 15px auto;
  display: flex;
  justify-content: center;
  align-items: center;
  list-style: none;
  outline: none;
}
.pagination > .active > a{
  background-color: #4A506A ;
  border-color: #4A506A ;
  color: #fff;
}
.pagination > li > a{
  border: 1px solid #4A506A ;
  padding: 5px 10px;
  outline: none;
  cursor: pointer;
}
.pagination > .active > a, .pagination > .active > span, .pagination > .active > a:hover, .pagination > .active > span:hover, .pagination > .active > a:focus, .pagination > .active > span:focus{
  background-color: #4A506A ;
  border-color: #4A506A;
  outline: none ;
}
.pagination > li > a, .pagination > li > span{
  color: #4A506A
}
.pagination > li:first-child > a, .pagination > li:first-child > span, .pagination > li:last-child > a, .pagination > li:last-child > span{
  border-radius: unset
}
  
`;