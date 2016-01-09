import React from 'react';
import { Link } from 'react-router';

class Sign extends React.Component {
  render() {
    let uri = "/reader/" + this.props.storyKey + "/" + this.props.option.targetChapterId;
    return (
        <li><Link to={uri}>{this.props.option.teaser}</Link></li>
    );
  }
}

class DecisionPoint extends React.Component {
  render() {

    let storyKey = this.props.storyKey;
    let isTheEnd = this.props.nextOptions === undefined || this.props.nextOptions.length === 0;

    let theEndOptions = !isTheEnd ? '' : <ul>
      <li><Link to={"/reader/" + this.props.storyKey}>Return to Chapter One</Link></li>
      <li><Link to="/">Choose Another Story</Link></li>
    </ul>;

    // TODO different options if end of story
    //<ul>
    //  <li><Link to={beginning}>Return to Chapter One</Link></li>
    //  <li><Link to="/">Choose Another Story</Link></li>
    //</ul>

    return (
      <div id="decisionPoint">
        <h3>Choose what to do next</h3>
        <ul>
          {this.props.nextOptions.map(function(option) {
              return <Sign key={option.targetChapterId} storyKey={storyKey} option={option} />;
            })}
        </ul>
        {theEndOptions}
      </div>
    );
  }
}

export default DecisionPoint;
