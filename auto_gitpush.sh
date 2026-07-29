#!/bin/bash

# Ir a la carpeta del script (por si lo ejecutás desde otro lado)
cd "$(dirname "$0")"

# Verificar si hay cambios
if [[ -z $(git status -s) ]]; then
    echo "🚫 No hay cambios para subir"
    exit 0
fi

# Mostrar estado
git status

# Pedir mensaje de commit
echo ""
echo "✏️ Escribí el mensaje del commit:"
read MESSAGE

# Si está vacío, usar automático
if [ -z "$MESSAGE" ]; then
    MESSAGE="auto commit $(date '+%Y-%m-%d %H:%M:%S')"
fi

# Ejecutar git
echo ""
echo "📦 Agregando archivos..."
git add .

echo "📝 Haciendo commit..."
git commit -m "$MESSAGE"

echo "🚀 Subiendo a GitHub..."
git push

echo ""
echo "✅ Listo! Todo subido correctamente"