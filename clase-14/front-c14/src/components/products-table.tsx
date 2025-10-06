"use client"

import type { ProductoDTO } from "@/types/producto"
import { Button } from "@/components/ui/button"
import { Card } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Pencil, Trash2, Loader2 } from "lucide-react"
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table"
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from "@/components/ui/alert-dialog"

interface ProductsTableProps {
  productos: ProductoDTO[]
  loading: boolean
  onEdit: (producto: ProductoDTO) => void
  onDelete: (id: number) => void
}

export function ProductsTable({ productos, loading, onEdit, onDelete }: ProductsTableProps) {
  if (loading) {
    return (
      <Card className="flex items-center justify-center p-12">
        <div className="flex flex-col items-center gap-3">
          <Loader2 className="h-8 w-8 animate-spin text-primary" />
          <p className="text-sm text-muted-foreground">Cargando productos...</p>
        </div>
      </Card>
    )
  }

  if (productos.length === 0) {
    return (
      <Card className="flex items-center justify-center p-12">
        <div className="text-center">
          <p className="text-lg font-medium text-card-foreground">No hay productos</p>
          <p className="text-sm text-muted-foreground">Comienza creando tu primer producto</p>
        </div>
      </Card>
    )
  }

  return (
    <Card className="overflow-hidden">
      <div className="overflow-x-auto">
        <Table>
          <TableHeader>
            <TableRow className="border-border hover:bg-muted/50 [&>th]:px-6 [&>th]:py-3">
              <TableHead className="text-card-foreground">ID</TableHead>
              <TableHead className="text-card-foreground">Nombre</TableHead>
              <TableHead className="text-card-foreground">Descripción</TableHead>
              <TableHead className="text-card-foreground">Precio ($)</TableHead>
              <TableHead className="text-card-foreground">Stock</TableHead>
              <TableHead className="text-card-foreground">Categoría</TableHead>
              <TableHead className="text-right text-card-foreground">Acciones</TableHead>
            </TableRow>
          </TableHeader>

          <TableBody>
            {productos.map((producto) => (
              <TableRow
                key={producto.id}
                className="border-border hover:bg-muted/30 [&>td]:px-6 [&>td]:py-4"
              >
                <TableCell className="font-mono text-sm text-muted-foreground">{producto.id}</TableCell>
                <TableCell className="font-medium text-card-foreground">{producto.nombre}</TableCell>
                <TableCell className="max-w-xs truncate text-muted-foreground">{producto.descripcion}</TableCell>
                <TableCell className="font-mono text-card-foreground">${producto.precio.toFixed(2)}</TableCell>
                <TableCell>
                  <Badge
                    variant={producto.cantidadEnStock > 10 ? "default" : "destructive"}
                    className="font-mono"
                  >
                    {producto.cantidadEnStock}
                  </Badge>
                </TableCell>
                <TableCell>
                  <Badge variant="outline" className="text-card-foreground">
                    {producto.categoria}
                  </Badge>
                </TableCell>

                <TableCell className="text-right">
                  <div className="flex justify-end gap-2">
                    <Button
                      variant="ghost"
                      size="icon"
                      onClick={() => onEdit(producto)}
                      className="h-8 w-8 text-card-foreground hover:bg-muted hover:text-primary"
                    >
                      <Pencil className="h-4 w-4" />
                      <span className="sr-only">Editar</span>
                    </Button>

                    <AlertDialog>
                      <AlertDialogTrigger asChild>
                        <Button
                          variant="ghost"
                          size="icon"
                          className="h-8 w-8 text-card-foreground hover:bg-destructive/10 hover:text-destructive"
                        >
                          <Trash2 className="h-4 w-4" />
                          <span className="sr-only">Eliminar</span>
                        </Button>
                      </AlertDialogTrigger>

                      <AlertDialogContent className="bg-card text-card-foreground">
                        <AlertDialogHeader>
                          <AlertDialogTitle>¿Estás seguro?</AlertDialogTitle>
                          <AlertDialogDescription className="text-muted-foreground">
                            Esta acción no se puede deshacer. El producto{" "}
                            <span className="font-semibold text-card-foreground">{producto.nombre}</span> será eliminado
                            permanentemente.
                          </AlertDialogDescription>
                        </AlertDialogHeader>
                        <AlertDialogFooter>
                          <AlertDialogCancel>Cancelar</AlertDialogCancel>
                          <AlertDialogAction
                            onClick={() => onDelete(producto.id)}
                            className="bg-destructive text-destructive-foreground hover:bg-destructive/90"
                          >
                            Eliminar
                          </AlertDialogAction>
                        </AlertDialogFooter>
                      </AlertDialogContent>
                    </AlertDialog>
                  </div>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </Card>
  )
}
