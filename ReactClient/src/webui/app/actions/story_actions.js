export const FETCH_CATALOG = 'FETCH_CATALOG';

export function fetchCatalog() {
  return {
    type: FETCH_CATALOG,
  };
}

export const LOAD_CATALOG = 'LOAD_CATALOG';

export function loadCatalog(results) {
  return {
    type: LOAD_CATALOG,
    payload: results,
  };
}

export const FETCH_CATALOG_ERR = 'FETCH_CATALOG_ERR';

export function fetchCatalogErr(errorMessage) {
  return {
    type: FETCH_CATALOG_ERR,
    payload: {
      message: errorMessage,
    },
  };
}

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
];
