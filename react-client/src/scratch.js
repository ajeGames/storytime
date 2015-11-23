var React = require('react');
var ReactDOM = require('react-dom');

var Reader = React.createClass({
  render: function() {
    return (
      <div>Bubba was here!</div>
    );
  }
});

ReactDOM.render(
    <Reader />,
    document.getElementById('reader')
);
