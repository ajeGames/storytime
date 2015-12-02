import React from 'react';

class TitleBar extends React.Component {
  render() {
    return (
        <div>
          <span className="title">{this.props.summary.title}</span> <span className="author">by {this.props.summary.author}</span>
        </div>
    );
  }
}

export default TitleBar;
