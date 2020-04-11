/* tslint:disable */
/* eslint-disable */
// @generated
// This file was automatically generated and should not be edited.

import { LifeCycleStatus } from "./globalTypes";

// ====================================================
// GraphQL query operation: FindAllMetrics
// ====================================================

export interface FindAllMetrics_findAllMetrics {
  __typename: "Metric";
  id: string;
  name: string;
  description: string | null;
  lifeCycleStatus: LifeCycleStatus;
}

export interface FindAllMetrics {
  findAllMetrics: (FindAllMetrics_findAllMetrics | null)[];
}
