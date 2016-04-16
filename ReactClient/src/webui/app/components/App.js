import React from 'react';
import {List} from 'immutable';

require('../../style/storytime.scss');

const summaries = List.of(
  {
    key: "11111111",
    title: "Story 1",
    author: "Bubba Gump 1",
    tagLine: "Read me 1"
  },
  {
    key: "22222222",
    title: "Story 2",
    author: "Bubba Gump 2",
    tagLine: "Read me 2"
  }
);

export default React.createClass({
  render: function() {
    return React.cloneElement(this.props.children, {storySummaries: summaries});
  }
});
