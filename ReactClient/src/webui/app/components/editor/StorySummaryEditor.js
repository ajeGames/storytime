import React from 'react';

const StorySummaryEditor = (props) => (
  <div>
    <div className="section">
      <div>Title: {props.summary.title}</div>
      <div>
        <label>Title:
          <input type="text" value={props.summary.title} />
        </label>
      </div>
      <div>Author: {props.summary.author}</div>
      <div>
        <label>Author:
          <input type="text" value={props.summary.author} />
        </label>
      </div>
      <div>Tag Line: {props.summary.tagLine}</div>
      <div>
        <label>Tag Line:
          <input type="text" value={props.summary.tagLine} />
        </label>
      </div>
      <div>Description: {props.summary.about}</div>
      <div>
        <label>Description:
          <textarea value={props.summary.about}></textarea>
        </label>
      </div>
      <button>Make Changes</button>
      <button>Save Story Summary</button>
    </div>
  </div>
);

StorySummaryEditor.propTypes = {
  summary: React.PropTypes.shape({
    title: React.PropTypes.string,
    author: React.PropTypes.string,
    tagLine: React.PropTypes.string,
    about: React.PropTypes.string,
  }),
};

export default StorySummaryEditor;
