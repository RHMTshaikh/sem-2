from torch import nn
ffmpeg -i "C:\Users\rahmat shaikh\Desktop\20240406_154942.mp4" -c:v libx265 -crf 28 "C:\Users\rahmat shaikh\Desktop\vid1.mp4"

exiftool -CreateDate="2024:04:07 12:00:00" "C:\Users\rahmat shaikh\Desktop\vid1.mp4"
