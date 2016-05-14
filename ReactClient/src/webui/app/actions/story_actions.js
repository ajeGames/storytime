export const a = [
  {
    type: 'LOAD_STORY',
    payload: {
      key: 'ABC123',
    },
  },
  {
    type: 'SET_TITLE',
    payload: {
      title: '',
    },
  },
  {
    type: 'SET_AUTHOR',
    payload: {
      author: '',
    },
  },
  {
    type: 'SET_TAG_LINE',
    payload: {
      tagLine: '',
    },
  },
  {
    type: 'SET_ABOUT',
    payload: {
      about: '',
    },
  },
  { type: 'FETCH_CATALOG' },
  { type: 'FETCH_CATALOG', status: 'error', error: 'Oops' },
  { type: 'FETCH_CATALOG', status: 'success', response: 'data' },
];
