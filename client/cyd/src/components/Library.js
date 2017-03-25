import React, { Component } from 'react';
import { Link } from 'react-router-dom';

const stories = [
  {
    key: "o9s0toym",
    title: "The Cave",
    author: "Bubba Gumpzzz",
    tagLine: "You want to read this.",
    about: "Sometimes life compels you great things.  And sometimes you'd rather play this game.",
    firstChapter: 1000
  },
  {
    "key": "5qcao3fu",
    "title": "Where the Water Goes",
    "author": "Mr. Bubbles",
    "tagLine": "Round and round and down and down",
    "about": "What happens when someone pulls the plug?",
    "firstChapter": 1000
  },
  {
    key: "12345678",
    title: "New Story A",
    author: "Bubba Gumpzzz",
    tagLine: "You want to read this.",
    about: "Sometimes life compels you great things.  And sometimes you'd rather play this game.",
    firstChapter: 1000
  },
  {
    "key": "09876543",
    "title": "New Story B",
    "author": "Mr. Bubbles",
    "tagLine": "Round and round and down and down",
    "about": "What happens when someone pulls the plug?",
    "firstChapter": 1000
  },
  {
    "key": "qwertyui",
    "title": "New Story C",
    "author": "Mr. Bubbles",
    "tagLine": "Round and round and down and down",
    "about": "What happens when someone pulls the plug?",
    "firstChapter": 1000
  },
];

function StoryCard(props) {
  return (
    <div className="col-md-4">
        <div className="catalog-item">
            <p><span className="title"><Link to="/stories/{props.story.key}/{props.story.firstChapter}">{props.story.title}</Link></span></p>
            <p><em>by {props.story.author}</em></p>
            <p>{props.story.tagLine}</p>
            <p>{props.story.about}</p>
        </div>
    </div>
  );
}

function CardCatalog(props) {
  const storyCards = props.stories.map((story) =>
    <StoryCard key={story.key} story={story} />
  );

  return (
    <div className="container">
      <div className="row">
        {storyCards}
      </div>
    </div>
  );
}

class Library extends React.Component {
  render() {
    return (
      <div className="panel panel-default">
          <div className="panel-heading">
              <h3 className="text-center panel-title">Welcome to the Library. Choose a Story.</h3></div>
          <div className="panel-body">
              <div className="container">
                <CardCatalog stories={stories} />
              </div>
          </div>
      </div>
    );
  }
}

export default Library;
