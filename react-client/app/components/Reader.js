import React from 'react';

require("../../public/storytime.css");

class Reader extends React.Component {
  render() {
    return (
      <div>
        <div id="header" className="row">
          Title by Author
        </div>
        <div id="main" className="row scroll-y">
          <div>
            Chapter Heading <br/>
            Prose <br/>
            Next Options <br/>
          </div>
        </div>
        <div id="footer" class="row">
          <div><a href="#/reader/{{this.props.storyKey}}">Return to Chapter One</a></div>
          <div><a href="#/catalog">Choose Another Story</a></div>
        </div>
      </div>
    )
  }
}

React.render(
    <Reader />,
    document.getElementById('app')
)

