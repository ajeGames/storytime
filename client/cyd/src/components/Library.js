import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { storySummaries } from '../api/sample-stories.js';

const StoryCard = (props) => (
  <div className="col-md-4">
      <div className="catalog-item">
          <p><span className="title">
            <Link to={`/reader/${props.story.key}/${props.story.firstChapter}`}>{props.story.title}</Link></span></p>
          <p><em>by {props.story.author}</em></p>
          <p>{props.story.tagLine}</p>
          <p>{props.story.about}</p>
      </div>
  </div>
);

function CardCatalog(props) {
  return (
    <div className="container">
      <div className="row">
        {props.stories.map((story) => <StoryCard key={story.key} story={story} />)}
      </div>
    </div>
  );
}

class Library extends Component {
  render() {
    return (
      <div className="panel panel-default">
          <div className="panel-heading">
              <h3 className="text-center panel-title">Welcome to the Library. Choose a Story.</h3></div>
          <div className="panel-body">
              <div className="container">
                <CardCatalog stories={storySummaries} />
              </div>
          </div>
      </div>
    );
  }
}

export default Library;
