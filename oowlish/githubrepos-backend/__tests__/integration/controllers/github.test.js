import request from 'supertest';
import app from '../../../src/app'

describe('Github', () => {

  it('should fetch repos if username exists', async () => {
    const response = await request(app)
    .get('/repos')
    .query({username: "lcdaponte"})
    .send();

    expect(response.status).toBe(200);
  });

  it('should not fetch repos if username do not exists', async () => {
    const response = await request(app)
    .get('/repos')
    .query({username: "tarcisotorres"})
    .send();

    expect(response.status).toBe(404);

  });

  it('should not fetch repos if username is blank', async () => {
    const response = await request(app)
    .get('/repos')
    .send();

    expect(response.status).toBe(400);
  });

  it('should not fetch repos if username length is less then 4 characters', async () => {
    const response = await request(app)
    .get('/repos')
    .query({username: "lcd"})
    .send();

    expect(response.status).toBe(400);
  });
});