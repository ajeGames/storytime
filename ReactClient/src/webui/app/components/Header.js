import React from 'react';

export default class Header extends React.Component {
  render() {
    return (
        <div id="masthead" className="masthead">
          <h1>{this.props.heading}</h1>
        </div>
    );
  }
}
