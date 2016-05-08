import React from 'react';
import { Link } from 'react-router';

export default class Header extends React.Component {
  render() {
    return (
        <div id="masthead" className="masthead">
          <h1>{this.props.heading}</h1>
          <menu>
            <Link to="/" activeClassName="active-menu-item">Home</Link> | <Link to="/library" activeClassName="active-menu-item">Library</Link> | <Link to="/story" activeClassName="active-menu-item">Story</Link> | <Link to="/editor" activeClassName="active-menu-item">Editor</Link>
          </menu>
        </div>
    );
  }
}
