import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IBorne, defaultValue } from 'app/shared/model/borne.model';

export const ACTION_TYPES = {
  FETCH_BORNE_LIST: 'borne/FETCH_BORNE_LIST',
  FETCH_BORNE: 'borne/FETCH_BORNE',
  CREATE_BORNE: 'borne/CREATE_BORNE',
  UPDATE_BORNE: 'borne/UPDATE_BORNE',
  DELETE_BORNE: 'borne/DELETE_BORNE',
  RESET: 'borne/RESET',
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IBorne>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false,
};

export type BorneState = Readonly<typeof initialState>;

// Reducer

export default (state: BorneState = initialState, action): BorneState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_BORNE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_BORNE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true,
      };
    case REQUEST(ACTION_TYPES.CREATE_BORNE):
    case REQUEST(ACTION_TYPES.UPDATE_BORNE):
    case REQUEST(ACTION_TYPES.DELETE_BORNE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true,
      };
    case FAILURE(ACTION_TYPES.FETCH_BORNE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_BORNE):
    case FAILURE(ACTION_TYPES.CREATE_BORNE):
    case FAILURE(ACTION_TYPES.UPDATE_BORNE):
    case FAILURE(ACTION_TYPES.DELETE_BORNE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload,
      };
    case SUCCESS(ACTION_TYPES.FETCH_BORNE_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.FETCH_BORNE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.CREATE_BORNE):
    case SUCCESS(ACTION_TYPES.UPDATE_BORNE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.DELETE_BORNE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {},
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState,
      };
    default:
      return state;
  }
};

const apiUrl = 'api/bornes';

// Actions

export const getEntities: ICrudGetAllAction<IBorne> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_BORNE_LIST,
  payload: axios.get<IBorne>(`${apiUrl}?cacheBuster=${new Date().getTime()}`),
});

export const getEntity: ICrudGetAction<IBorne> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_BORNE,
    payload: axios.get<IBorne>(requestUrl),
  };
};

export const createEntity: ICrudPutAction<IBorne> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_BORNE,
    payload: axios.post(apiUrl, cleanEntity(entity)),
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IBorne> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_BORNE,
    payload: axios.put(apiUrl, cleanEntity(entity)),
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IBorne> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_BORNE,
    payload: axios.delete(requestUrl),
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET,
});
