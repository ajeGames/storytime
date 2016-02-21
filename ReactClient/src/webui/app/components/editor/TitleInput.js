import React, { PropTypes } from 'react'

const TitleInput = ({ text, edit, onChange }) => {
  if (edit === "true") {
    return (
        <div>
          <label>Title:
            <input type="text" value={text} onChange={onChange} />
          </label>
        </div>
    )
  } else {
    return (
        <div>
          <div>Title: {text}</div>
        </div>
    )
  }
};

TitleInput.propTypes = {
  text: PropTypes.string.isRequired
}

export default TitleInput
