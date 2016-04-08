import React from 'react';
import Catalog from './Catalog'

class Home extends React.Component {
  render() {
    let summaries = [
      {
        key: "11111111",
        title: "Story 1",
        author: "Bubba Gump 1",
        tagLine: "Read me 1"
      },
      {
        key: "22222222",
        title: "Story 2",
        author: "Bubba Gump 2",
        tagLine: "Read me 2"
      }
    ];

    return (
        <div>
          <Catalog storySummaries={summaries}/>
        </div>
    );
  }
}

export default Home;
