import React from 'react';
import Entry from './Entry';

class Catalog extends React.Component {

  getSummaries() {
    return this.props.storySummaries || [];
  }

  render() {
    return (
      <div className="catalog">
        <h1>Library</h1>
        <h2>Which story would you like to try?</h2>
        <div>
          <ul>
            {this.getSummaries().map(summary => <Entry summary={summary} />)}
          </ul>
        </div>
      </div>
    );
  }
}

Catalog.propTypes = {
  storySummaries: React.PropTypes.arrayOf(React.PropTypes.object),
};

export default Catalog;
