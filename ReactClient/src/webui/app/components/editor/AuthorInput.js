import React from 'react';

class AuthorInput extends React.Component {
  constructor() {
    super();
  }

  handleChange(event) {
  }

  render() {
    return (
        <div>
          <label>Author:
            <input type="text" value="" onChange={this.handleChange}/>
          </label>
        </div>
    );
  }
}

export default TitleInput;
