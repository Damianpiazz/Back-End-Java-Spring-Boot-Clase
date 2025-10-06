"use client"

import { useState, useEffect } from "react"
import { ProductsTable } from "./products-table"
import { ProductForm } from "./product-form"
import { Button } from "@/components/ui/button"
import { Plus, Package } from "lucide-react"
import { toast } from "sonner"

import {
  listarProductos,
  crearProducto,
  actualizarProducto,
  eliminarProducto,
} from "@/services/productos"

import type { ProductoDTO, ProductoCreateDTO } from "@/types/producto"

export function ProductsManager() {
  const [productos, setProductos] = useState<ProductoDTO[]>([])
  const [loading, setLoading] = useState(true)
  const [showForm, setShowForm] = useState(false)
  const [editingProduct, setEditingProduct] = useState<ProductoDTO | null>(null)

  useEffect(() => {
    fetchProductos()
  }, [])

  const fetchProductos = async () => {
    try {
      setLoading(true)
      const data = await listarProductos()
      setProductos(data)
    } catch (error) {
      console.error(error)
      toast.error("No se pudieron cargar los productos")
    } finally {
      setLoading(false)
    }
  }

  const handleCreate = async (producto: ProductoCreateDTO) => {
    try {
      await crearProducto(producto)
      await fetchProductos()
      setShowForm(false)
      toast.success("Producto creado correctamente")
    } catch (error) {
      console.error(error)
      toast.error("Error al crear producto")
    }
  }

  const handleUpdate = async (id: number, producto: ProductoCreateDTO) => {
    try {
      await actualizarProducto(id, producto)
      await fetchProductos()
      setShowForm(false)
      setEditingProduct(null)
      toast.success("Producto actualizado correctamente")
    } catch (error) {
      console.error(error)
      toast.error("Error al actualizar producto")
    }
  }

  const handleDelete = async (id: number) => {
    try {
      await eliminarProducto(id)
      await fetchProductos()
      toast.success("Producto eliminado correctamente")
    } catch (error) {
      console.error(error)
      toast.error("Error al eliminar producto")
    }
  }

  const handleEdit = (producto: ProductoDTO) => {
    setEditingProduct(producto)
    setShowForm(true)
  }

  const handleCloseForm = () => {
    setShowForm(false)
    setEditingProduct(null)
  }

  return (
    <div className="min-h-screen bg-background">
      {/* HEADER */}
      <div className="border-b border-border bg-card">
        <div className="container mx-auto px-4 py-6">
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center rounded-lg bg-primary/10">
                <Package className="h-5 w-5 text-primary" />
              </div>
              <div>
                <h1 className="text-2xl font-bold text-card-foreground">TechLab Productos</h1>
                <p className="text-sm text-muted-foreground">Gestión del catálogo desde Spring Boot</p>
              </div>
            </div>
            <Button onClick={() => setShowForm(true)} className="gap-2" disabled={showForm}>
              <Plus className="h-4 w-4" />
              Nuevo Producto
            </Button>
          </div>
        </div>
      </div>

      {/* BODY */}
      <div className="container mx-auto px-4 py-8">
        {showForm ? (
          <ProductForm
            producto={editingProduct}
            onSubmit={
              editingProduct
                ? (data) => handleUpdate(editingProduct.id, data)
                : handleCreate
            }
            onCancel={handleCloseForm}
          />
        ) : (
          <ProductsTable
            productos={productos}
            loading={loading}
            onEdit={handleEdit}
            onDelete={handleDelete}
          />
        )}
      </div>
    </div>
  )
}
