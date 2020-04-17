import React, {FunctionComponent} from 'react';
import {
    TableContainer,
    Table,
    TableHead,
    TableRow,
    TableCell,
    TableBody
} from "@material-ui/core";
import {makeStyles} from "@material-ui/core/styles";
import {useFindAllMetricsQuery} from "../queries/FindAllMetricsQuery";

const useStyles = makeStyles({
    tableHeader: {
        "& > th": {
            fontWeight: "bold"
        }
    }
});

export const Metric: FunctionComponent = () => {
    const classes = useStyles();
    const findAllMetrics = useFindAllMetricsQuery();
    if (findAllMetrics.error) {
        return <>{findAllMetrics.error.message}</>;
    }
    if (findAllMetrics.loading || !findAllMetrics.data || !findAllMetrics.data.findAllMetrics) {
        return <>Loading...</>;
    }
    return (
        <TableContainer>
            <Table>
                <TableHead>
                    <TableRow className = {classes.tableHeader}>
                        <TableCell>Name</TableCell>
                        <TableCell>Description</TableCell>
                        <TableCell>Life Cycle Status</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {findAllMetrics.data.findAllMetrics.map((row, index) => (
                        <TableRow key={(row && row.id) || index.toString()}>
                            <TableCell>{ row && row.name }</TableCell>
                            <TableCell>{ row && row.description }</TableCell>
                            <TableCell>{ row && row.lifeCycleStatus }</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
};