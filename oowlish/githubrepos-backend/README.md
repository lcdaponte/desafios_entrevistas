<h1 align="center">
    <a href="#"> GITHUBREPOS-BACKEND </a>
</h1>

<h3 align="center">
    An API for fetching Github repositories by username.
</h3>

<p align="center">
   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
</p>


<h4 align="center"> 🚧 GithubRepos-backend  - Work in progress... 🚧 </h4>

<p align="center">
 <a href="#about">About</a> •
 <a href="#features">Features</a> •
 <a href="#how-it-works">How it works</a> • 
 <a href="#tech-stack">Tech Stack</a> • 
 <a href="#author">Author</a> • 
 <a href="#user-content-license">License</a>

</p>


## About

GithubRepos-backend - is a way to find repositories from your favorite developers and companies. With list of repositories shown to you, with a click of a button, you are redirected to the desired repository where you can find even more information.

---

## Features

- [x] Users have access to the web application, where they can:
   - [x] browse the repositories by username

---

## How it works

This project is divided into two parts:
1. Backend (this project)
2. [Frontend ](https://github.com/lcdaponte/githubrepos-client)(separate project)

Frontend needs the Backend to be running to work.

### Pre-requisites

Before you begin, you will need to have the following tools installed on your machine:
[Git](https://git-scm.com), [Node.js](https://nodejs.org/en/).
In addition, it is good to have an editor to work with the code like [VSCode](https://code.visualstudio.com/)

#### Running  Backend 

```bash

# Clone this repository
$ git clone git@github.com:lcdaponte/githubrepos-backend.git

# Access the project folder cmd/terminal
$ cd githubrepos-backend

# install the dependencies
$ npm install

# Run the application in development mode
$ npm run dev

# The server will start at port: 3333 - go to http://localhost:3333

# To run the tests
$ npm test

```

## Tech Stack

The following tools were used in the construction of the project:

-   **[NodeJS](https://nodejs.org/en/)**
-   **[Express](https://expressjs.com/)**
-   **[CORS](https://expressjs.com/en/resources/middleware/cors.html)**
-   **[Axios](https://github.com/axios/axios)**
-   **[Nodemon](https://github.com/remy/nodemon)**
> See the file  [package.json](https://github.com/lcdaponte/githubrepos-backend/blob/master/package.json)

---

## Author

<a href="https://github.com/lcdaponte">
 <img style="border-radius: 50%;" src="https://avatars3.githubusercontent.com/u/3715622?s=400&u=b66b45b2fb83a22260d52bcc4c15fdd1aab334c4&v=4" width="150px;" alt="Lucas Cavalcante"/>
 <br />
 <sub><b>Lucas Cavalcante</b></sub></a> <a href="https://github.com/lcdaponte" title="Github"></a>
 <br />

 [![Linkedin Badge](https://img.shields.io/badge/-Lucas-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/lcdaponte/)](https://www.linkedin.com/in/lcdaponte/) 
[![Gmail Badge](https://img.shields.io/badge/-lcdaponte@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:lcdaponte@gmail.com)](mailto:lcdaponte@gmail.com)

---

## License

This project is under the license [MIT](./LICENSE).