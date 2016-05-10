import React from 'react';

const TitleBar = (props) => (
  <div id="title" className="section">
    <span className="title">{props.title}</span>
    <span className="author">by {props.author}</span>
  </div>
);

TitleBar.propTypes = {
  title: React.PropTypes.string,
  author: React.PropTypes.string,
};

export default TitleBar;
