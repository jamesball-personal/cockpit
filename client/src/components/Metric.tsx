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

const useStyles = makeStyles({
    tableHeader: {
        "& > th": {
            fontWeight: "bold"
        }
    }
});

export const Metric: FunctionComponent = () => {
    const classes = useStyles();
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
                    <TableRow>
                        <TableCell>Defects found</TableCell>
                        <TableCell>How many defects were found?</TableCell>
                        <TableCell>ACTIVE</TableCell>
                    </TableRow>
                    <TableRow>
                        <TableCell>Customers satisfied</TableCell>
                        <TableCell>How many customers are satisfied with the product?</TableCell>
                        <TableCell>CANCELLED</TableCell>
                    </TableRow>
                </TableBody>
            </Table>
        </TableContainer>
    );
};