import React from 'react';
import { Link } from 'react-router';

const Entry = (props) => (
  <li key={props.summary.key}>
    <Link to="/story/{summary.key}">{props.summary.title}</Link> by {props.summary.author}
    - {props.summary.tagLine}
  </li>
);

Entry.propTypes = {
  summary: React.PropTypes.object,
};
