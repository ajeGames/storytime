import React from 'react';
import TitleInput from './TitleInput';

class StorySummaryEditor extends React.Component {

  constructor() {
    super();
  }

  render() {
    return (
        <div>
          <h2>StorySummaryEditor</h2>
          <TitleInput />
          <p>Plus more inputs...AuthorInput, TagLineInput, DescriptionInput</p>
          <p>And a SaveStorySummary button</p>
        </div>
    );
  }
}

export default StorySummaryEditor;
