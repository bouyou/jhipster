import { Moment } from 'moment';

export interface IBorne {
  id?: string;
  x?: number;
  y?: number;
  amenageur?: string;
  operateur?: string;
  nenseigne?: string;
  idstation?: number;
  nstation?: string;
  adstation?: string;
  codeinsee?: string;
  xlongitude?: number;
  ylatitude?: number;
  nbrepdc?: number;
  idpdc?: number;
  puissmax?: number;
  typeprise?: string;
  accesrecharge?: string;
  accessibilite?: string;
  observations?: string;
  datemajnoperateur?: string;
}

export const defaultValue: Readonly<IBorne> = {};
