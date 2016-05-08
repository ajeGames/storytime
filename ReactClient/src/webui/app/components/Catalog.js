import React from 'react';
import { Link } from 'react-router';
import BackendAccess from './remote/BackendAccess';

class Catalog extends React.Component {

  //constructor() {
  //  super();
  //  this.state = { summaries: [] }
  //}
  //
  //componentDidMount() {
  //  let backend = new BackendAccess();
  //  backend.loadSummaries(this);
  //}
  //
  //_handleSuccess(summaries) {
  //  this.setState( { summaries: summaries });
  //}

  getSummaries() {
    return this.props.storySummaries || []
  }

  render() {
    let summaries = this.getSummaries();

    return (
        <div class="catalog">
          <h1>Library</h1>
          <h2>Which story would you like to try?</h2>
          <div>
            <ul>
              {summaries.map(function (summary) {
                return <li key={summary.key}>
                  <Link to={'/story/' + summary.key}>{summary.title}</Link> by {summary.author} - {summary.tagLine}
                </li>
              })}
            </ul>
          </div>
        </div>
    );
  }
}

export default Catalog;
