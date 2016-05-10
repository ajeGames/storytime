import React from 'react';
import { Link } from 'react-router';

const Header = (props) => (
  <div id="masthead" className="masthead">
    <h1>{props.heading}</h1>
    <menu>
      <Link to="/" activeClassName="active-menu-item">Home</Link>
      | <Link to="/library" activeClassName="active-menu-item">Library</Link>
      | <Link to="/story" activeClassName="active-menu-item">Story</Link>
      | <Link to="/editor" activeClassName="active-menu-item">Editor</Link>
    </menu>
  </div>
);

Header.propTypes = {
  heading: React.PropTypes.string,
};

export default Header;
