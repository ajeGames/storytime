import axios from 'axios';

class StoryTimeAPI {
  loadSummaries() {
    const endpoint = '/api/storytime/stories';
    axios.get(endpoint)
      .then(response => (console.log(response.data)))
      .catch(response => (console.log(response.message)));
    /*
     successful result should update redux store
     */
  }

  loadStory(storyKey) {  // eslint-disable-line
    const endpoint = '{this.uriBase}/story/${storyKey}/full';
    axios.get(endpoint)
      .then(response => (console.log(response.data)))
      .catch(response => (console.log(response.message)));
  }
}

export default StoryTimeAPI;
