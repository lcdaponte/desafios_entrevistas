import githubapi from '../../services/githubapi';

class GithubController{
  constructor(){
    // this.baseUrl = `https://api.github.com/`;
  }
  async fetchrepos(req, res){
    const { username } = req.query;
    let response;
    let data;

    if(!username)
      return res.status(400).json({error: 'An username is required. Fill the username field and try again.'});
    
    if(username.length < 4)
      return res.status(400).json({error: 'An username has a 4 character minimum. Fill the username field correctly and try again.'});
    
    try {
      response = await githubapi.get(`/users/${username}/repos`);
    } catch (error) {
      return res.status(404).json({error: 'An error occured while processing your request.'});
    }

    if(response.data.length > 0){
      const { owner } = response.data[0];

    
      const repositories = response.data.map((repo) => {
        return {name: repo.name,
          url: repo.html_url};
      });

       data = {
        avatar: owner.avatar_url,
        username: owner.login,
        repositories: repositories
      }

      return res.json(data);
    }
    
    return res.json({});
  }

}

export default new GithubController();