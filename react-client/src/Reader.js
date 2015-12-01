import React from 'react';
import ReactDOM from 'react-dom';
import Chapter from './Chapter'

require("./storytime.css");

class TitleBar extends React.Component {
  render() {
    return (
      <div>
        <span className="title">{this.props.summary.title}</span> <span className="author">by {this.props.summary.author}</span>
      </div>
    );
  };
}

class Sign extends React.Component {
  render() {
    return (
      <div className="nextChapterOption"><a href="#STORY_KEY/{this.props.option.targetChapterId}">{this.props.option.teaser}</a></div>
    );
  };
}

class SignPost extends React.Component {
  render() {
    let choices = [];

    // TODO different options if end of story

    this.props.chapter.nextChapterOptions.forEach(function(option) {
      rows.push(<Sign option={option} />)
    });

    return (
      <div id="nextChapters">
        {choices}
      </div>
    );
  }
}

class Reader extends React.Component {
  render() {
    return (
      <div>
        <div id="header" className="row">
          <TitleBar summary={this.props.story.summary} />
        </div>
        <div id="main" className="row scroll-y">
          <Chapter chapter={this.props.story.summary.firstChapter} />
        </div>
      </div>
    );
  };
}

let SHORT_SAMPLE_STORY = {
  summary : {
    key : "o9s0toym",
    title : "The Cave",
    author : "Bubba Gump",
    tagLine : "What lies beneath",
    about : "See where your choices lead.  You can choose your own destiny, but can you escape fate?",
    firstChapter : {
      targetChapterId : 1000,
      teaser : "This might be a good day to take some risks."
    }
  },
  chapters : [
    {
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
    },{
      id : 1001,
      heading : "You Win!",
      prose : "As your eyes adjust to the light, you see an amazing sight.  The room is filled with treasure, most likely abandoned by pirate many centuries ago.  You take the treasure out of the cave, and bring it home.  There is enough wealth for a lifetime of enjoyment.  Congratulations!",
      nextChapterOptions : []
    },{
      id : 1002,
      heading : "You Die!",
      prose : "Unfortunately, fate is not on your side today.  As you step around the rocks, you are bitten by a rattlesnake.  Now you realize what that ominous noise was.  If only you had been paying attention.\n\nSorry.",
      nextChapterOptions : []
    }
  ]
};

ReactDOM.render(
  <Reader story={SHORT_SAMPLE_STORY} />,
  document.getElementById('reader')
);

export default Reader
