import React, { Component } from 'react';
import { Container, Row, Button } from 'reactstrap';

class NumberGuessing extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: 'Guess My Number',
      answer: this.chooseAnswer(),
      guess: ''
    };

    this.handleInput = this.handleInput.bind(this);
    this.checkGuess = this.checkGuess.bind(this);
  }

  chooseAnswer() {
    const max = 100;
    const min = 0;
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  handleInput(event) {
    // let guess = (Number(event.target.value)
    this.setState({guess: event.target.value});
  }

  checkGuess(event) {
    event.preventDefault();

    var msg = 'Enter a number.';
    if (!isNaN(this.state.guess)) {
      const guess = Number(this.state.guess);
      if (guess < this.state.answer) {
        msg = this.state.guess + ' is too low.';
      } else if (guess > this.state.answer) {
        msg = this.state.guess + ' is too high.';
      } else {
        msg = 'You got it!';
      }
    }
    this.setState({message: msg});
  }

  renderHistory() {
    return (
      <Row>
        <h2>Previous Guesses</h2>

      </Row>
    );
  }

  render() {
    return (
      <Container style={{marginTop: 5 + 'em'}}>
        <Row className="text-center">
          <h1>{this.state.message}</h1>
          <form>
            <p>
              <input
                autoFocus
                type="text"
                value={this.state.guess}
                size="5"
                onChange={this.handleInput}
              />
              <Button
                style={{marginLeft: 0.5 + 'em'}}
                onClick={this.checkGuess}
              >
                Guess
              </Button>
            </p>
          </form>
        </Row>
      </Container>
    )
  }
}

export default NumberGuessing;
