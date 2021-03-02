import { Router } from 'express';
import GithubController from './app/controllers/GithubController';

const routes = new Router();

routes.get('/repos', GithubController.fetchrepos);

export default routes;