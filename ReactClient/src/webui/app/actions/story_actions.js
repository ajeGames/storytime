import axios from 'axios';

export const FETCH_CATALOG = 'FETCH_CATALOG';
export const LOAD_CATALOG = 'LOAD_CATALOG';
export const FETCH_CATALOG_ERR = 'FETCH_CATALOG_ERR';

export function fetchCatalog() {
  return {
    type: FETCH_CATALOG,
  };
}

export function loadCatalog(results) {
  return {
    type: LOAD_CATALOG,
    payload: {
      stories: results,
    },
  };
}

export function fetchCatalogErr(errorMessage) {
  return {
    type: FETCH_CATALOG_ERR,
    payload: {
      message: errorMessage,
    },
  };
}

export function fetchCatalogFromRemote() {
  return dispatch => {
    dispatch(fetchCatalog());
    return axios.get('/api/storytime/stories')
      .then(response => response.data)
      .then(data => dispatch(loadCatalog(data)));
  };
}

// TODO incorporate these actions later
// export const a = [
//  {
//    type: 'LOAD_STORY',
//    payload: {
//      key: 'ABC123',
//    },
//  },
//  {
//    type: 'SET_TITLE',
//    payload: {
//      title: '',
//    },
//  },
//  {
//    type: 'SET_AUTHOR',
//    payload: {
//      author: '',
//    },
//  },
//  {
//    type: 'SET_TAG_LINE',
//    payload: {
//      tagLine: '',
//    },
//  },
//  {
//    type: 'SET_ABOUT',
//    payload: {
//      about: '',
//    },
//  },
// ];
