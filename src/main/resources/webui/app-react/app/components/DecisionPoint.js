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
        let options = this.props.nextOptions;
        let isTheEnd = options === undefined || options.length === 0;
        let theEndOptions = !isTheEnd ? '' : <ul>
            <li><Link to={"/reader/" + storyKey}>Return to Chapter One</Link></li>
            <li><Link to="/">Choose Another Story</Link></li>
        </ul>;

        return (
            <div id="decisionPoint">
                <h3>Choose what to do next</h3>
                <ul>
                    {options.map(function(option) {
                        return <Sign key={option.targetChapterId} storyKey={storyKey} option={option} />;
                    })}
                </ul>
                {theEndOptions}
            </div>
        );
    }
}

export default DecisionPoint;
