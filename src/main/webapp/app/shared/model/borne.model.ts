import { Moment } from 'moment';

export interface IBorne {
  id?: string;
  x?: number;
  y?: number;
  amenageur?: string;
  operateur?: string;
  enseigne?: string;
  idstation?: string;
  station?: string;
  adstation?: string;
  codeinsee?: number;
  xlongitude?: number;
  ylatitude?: number;
  nbrepdc?: string;
  idpdc?: string;
  puissmax?: string;
  typeprise?: string;
  accesrecharge?: string;
  accessibilite?: string;
  observations?: string;
  datemajnoperateur?: string;
}

export const defaultValue: Readonly<IBorne> = {};
