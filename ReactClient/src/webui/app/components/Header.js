import React from 'react';
import { Link } from 'react-router';

export default class Header extends React.Component {
  render() {
    return (
        <div id="masthead" className="masthead">
          <h1>{this.props.heading}</h1>
          <menu>
            <Link to="/">Home</Link> | <Link to="/library">Library</Link> | <Link to="/story">Story</Link> | <Link to="/editor">Editor</Link>
          </menu>
        </div>
    );
  }
}
