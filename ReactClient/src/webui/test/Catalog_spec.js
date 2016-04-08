import React from 'react';
import ReactDOM from 'react-dom';
import { renderIntoDocument, scryRenderedDOMComponentsWithTag } from 'react-addons-test-utils';
import Catalog from '../app/components/Catalog';
import {expect} from 'chai';

describe('Catalog', () => {

  const stories = [
    {
      key: "11111111",
      title: "Story 1",
      author: "Bubba Gump 1",
      tagLine: "Read me 1"
    },
    {
      key: "22222222",
      title: "Story 2",
      author: "Bubba Gump 2",
      tagLine: "Read me 2"
    },
    {
      key: "33333333",
      title: "Story 3",
      author: "Bubba Gump 3",
      tagLine: "Read me 3"
    }
  ];

  it('lists available stories', () => {
    const component = renderIntoDocument(
        <Catalog storySummaries={stories} />
    );
    const listItems = scryRenderedDOMComponentsWithTag(component, 'li');

    expect(listItems.length).to.equal(3);
  });

});
