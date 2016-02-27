import React, { PropTypes } from 'react'

const TitleInput = ({ text, edit, onChange }) => {
  if ("true" === edit) {
  return (
      <div>
        <label>Title:
          <input type="text" value={text} onChange={onChange} />
        </label>
      </div>
  )
}
  return (
      <div>
        <div>Title: {text}</div>
      </div>
  )
};

TitleInput.propTypes = {
  text: PropTypes.string.isRequired
}

export default TitleInput
