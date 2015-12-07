import React from 'react';
import ReactDOM from 'react-dom';
import TitleBar from './TitleBar';
import Chapter from './Chapter';

class Reader extends React.Component {
  render() {
    const summary = {
      key : "o9s0toym",
      title : "The Cave",
      author : "Bubba Gump",
      tagLine : "What lies beneath",
      about : "See where your choices lead.  You can choose your own destiny, but can you escape fate?",
      firstChapter : {
        targetChapterId : 1000,
        teaser : "This might be a good day to take some risks."
      }
    };

    const chapter = {
      id : 1000,
      heading : "The Cave",
      prose : "It's a nice day, so you decide to go for a walk.  As you stroll along, you see a clearing with an outcrop of rocks.  Something is unusual about these rocks, some blackness unlike the surrounding soil.  You notice that this is an opening to a cave.  It is dark inside, and you wonder how far it goes.\n\nWhat would you like to do?",
      nextChapterOptions : [
        {
          targetChapterId : 1001,
          teaser : "Step inside."
        },{
          targetChapterId : 1002,
          teaser : "Continue walking."
        }
      ]
    };

    return (
      <div id="reader">
        <TitleBar summary={summary} />
        <Chapter chapter={chapter} storyKey={summary.key} />
      </div>
    )
  }
}

export default Reader;
