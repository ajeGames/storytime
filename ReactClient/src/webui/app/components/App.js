import React from 'react';
import { List } from 'immutable';

require('../styles/main.scss');

const summaries = List.of(
  {
    key: '11111111',
    title: 'Story 1',
    author: 'Bubba Gump 1',
    tagLine: 'Read me 1',
  },
  {
    key: '22222222',
    title: 'Story 2',
    author: 'Bubba Gump 2',
    tagLine: 'Read me 2',
  }
);

class App extends React.Component {
  render() {
    return React.cloneElement(this.props.children, { storySummaries: summaries });
  }
}

App.propTypes = {
  children: React.PropTypes.node,
};

export default App;
