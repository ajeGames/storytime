import React from 'react';

class TitleBar extends React.Component {
  render() {
    return (
        <div id="title" className="section">
          <span className="title">{this.props.summary.title}</span> <span className="author">by {this.props.summary.author}</span>
        </div>
    );
  }
}

export default TitleBar;
