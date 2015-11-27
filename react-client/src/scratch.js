/*
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


/!*
 Components:

 Reader
 Title Bar
 Chapter
 SignPost
 Sign
 Ending (suggestions for what to do next)
 Suggestion
 *!/

class TitleBar extends React.Component {
  render() {
    return (
        <div>
          <span class="title">{this.props.summary.title}</span>
          <span class="author">by {this.props.summary.author}</span>
        </div>
    );
  };
}

var Chapter = React.createClass({
  render: function() {
    return (
        <div>
          <div class="chapterTitle">{this.props.chapter.heading}</div>
          <div id="prose">
            {this.props.chapter.prose}
          </div>
        </div>
    );
  }
});

var Sign = React.createClass({
  render: function() {
    return (
        <div class="nextChapterOption"><a href="#STORY_KEY/{this.props.option.targetChapterId}">{this.props.option.teaser}</a></div>
    );
  }
});

var SignPost = React.createClass({
  render: function() {
    var choices = [];

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
});

var Reader = React.createClass({
  render: function() {
    return (
        <div>
          <div id="header" class="row">
            <TitleBar summary={this.props.story.summary} />
          </div>
          <div id="main" class="row scroll-y">
            <Chapter chapter={this.props.story.chapters[0]} />
            <SignPost next={chapter.nextChapterOptions} />
          </div>
        </div>
    );
  }
});

var SHORT_SAMPLE_STORY = {
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
    document.getElementById('reader-node')
);

export default Reader
*/
