"use client"

import type React from "react"
import { useState, useEffect } from "react"
import type { ProductoDTO, ProductoCreateDTO } from "@/types/producto"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Textarea } from "@/components/ui/textarea"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { X } from "lucide-react"

interface ProductFormProps {
  producto: ProductoDTO | null
  onSubmit: (data: ProductoCreateDTO) => void
  onCancel: () => void
}

export function ProductForm({ producto, onSubmit, onCancel }: ProductFormProps) {
  const [formData, setFormData] = useState<ProductoCreateDTO>({
    nombre: "",
    descripcion: "",
    precio: 0,
    cantidadEnStock: 0,
    categoria: "",
  })

  useEffect(() => {
    if (producto) {
      setFormData({
        nombre: producto.nombre,
        descripcion: producto.descripcion,
        precio: producto.precio,
        cantidadEnStock: producto.cantidadEnStock,
        categoria: producto.categoria,
      })
    }
  }, [producto])

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()
    onSubmit(formData)
  }

  return (
    <Card className="mx-auto max-w-2xl">
      <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-4">
        <CardTitle className="text-2xl text-card-foreground">
          {producto ? "Editar Producto" : "Nuevo Producto"}
        </CardTitle>
        <Button
          variant="ghost"
          size="icon"
          onClick={onCancel}
          className="h-8 w-8 text-muted-foreground hover:text-card-foreground"
        >
          <X className="h-4 w-4" />
          <span className="sr-only">Cerrar</span>
        </Button>
      </CardHeader>

      <CardContent>
        <form onSubmit={handleSubmit} className="space-y-6">
          {/* Nombre y Categoria */}
          <div className="grid gap-6 md:grid-cols-2">
            <div className="space-y-2">
              <Label htmlFor="nombre" className="text-card-foreground">
                Nombre *
              </Label>
              <Input
                id="nombre"
                value={formData.nombre}
                onChange={(e) => setFormData({ ...formData, nombre: e.target.value })}
                required
                className="bg-input text-card-foreground"
                placeholder="Ej: Yerba Mate Premium"
              />
            </div>

            <div className="space-y-2">
              <Label htmlFor="categoria" className="text-card-foreground">
                Categoría *
              </Label>
              <Input
                id="categoria"
                value={formData.categoria}
                onChange={(e) => setFormData({ ...formData, categoria: e.target.value })}
                required
                className="bg-input text-card-foreground"
                placeholder="Ej: Infusiones"
              />
            </div>
          </div>

          {/* Descripcion */}
          <div className="space-y-2">
            <Label htmlFor="descripcion" className="text-card-foreground">
              Descripción *
            </Label>
            <Textarea
              id="descripcion"
              value={formData.descripcion}
              onChange={(e) => setFormData({ ...formData, descripcion: e.target.value })}
              required
              rows={4}
              className="bg-input text-card-foreground"
              placeholder="Describe las características del producto..."
            />
          </div>

          {/* Precio y Stock */}
          <div className="grid gap-6 md:grid-cols-2">
            <div className="space-y-2">
              <Label htmlFor="precio" className="text-card-foreground">
                Precio ($) *
              </Label>
              <Input
                id="precio"
                type="number"
                step="0.01"
                min="0"
                value={formData.precio}
                onChange={(e) =>
                  setFormData({ ...formData, precio: Number.parseFloat(e.target.value) })
                }
                required
                className="bg-input text-card-foreground"
                placeholder="2500.50"
              />
            </div>

            <div className="space-y-2">
              <Label htmlFor="cantidadEnStock" className="text-card-foreground">
                Cantidad en stock *
              </Label>
              <Input
                id="cantidadEnStock"
                type="number"
                min="0"
                value={formData.cantidadEnStock}
                onChange={(e) =>
                  setFormData({ ...formData, cantidadEnStock: Number.parseInt(e.target.value) })
                }
                required
                className="bg-input text-card-foreground"
                placeholder="100"
              />
            </div>
          </div>

          {/* Botones */}
          <div className="flex gap-3 pt-4">
            <Button type="button" variant="outline" onClick={onCancel} className="flex-1 bg-transparent">
              Cancelar
            </Button>
            <Button type="submit" className="flex-1">
              {producto ? "Actualizar" : "Crear"} Producto
            </Button>
          </div>
        </form>
      </CardContent>
    </Card>
  )
}
