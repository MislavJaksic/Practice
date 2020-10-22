import os
import sys

# Adds "katas" to sys.path
# Now you can do import with "from katas.Sub-Package ..."
sys.path.insert(
    0, os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "katas"))
)
