import React from 'react';

class TitleInput extends React.Component {
  constructor() {
    super();
    this.state = {
      value: 'The Big One'
    };
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  render() {
    return (
        <label>Title:
          <input type="text" value={this.state.value} onChange={this.handleChange}/>
        </label>
    );
  }
}

export default TitleInput;
