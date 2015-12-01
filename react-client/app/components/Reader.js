import React from 'react';

class Reader extends React.Component {
  render() {
    return (
      <div>
        Hello, world
      </div>
    )
  }
}

React.render(
    <Reader />,
    document.getElementById('app')
)

